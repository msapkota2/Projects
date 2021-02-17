const invertHex = (hex) => {
    return (Number(`0x1${hex}`) ^ 0xFFFFFF).toString(16).substr(1).toUpperCase() //beatuiful code but its not mine;
} //source https://stackoverflow.com/questions/35969656/how-can-i-generate-the-opposite-color-according-to-current-color

const socket = io('https://calm-bayou-23742.herokuapp.com');

const colorArray = ['FF6633', 'FFB399', 'FF33FF', 'FFFF99', '00B3E6',
    'E6B333', '3366E6', '999966', '99FF99', 'B34D4D',
    '80B300', '809900', 'E6B3B3', '6680B3', '66991A',
    'FF99E6', 'CCFF1A', 'FF1A66', 'E6331A', '33FFCC',
    '66994D', 'B366CC', '4D8000', 'B33300', 'CC80CC',
    '66664D', '991AFF', 'E666FF', '4DB3FF', '1AB399',
    'E666B3', '33991A', 'CC9999', 'B3B31A', '00E680',
    '4D8066', '809980', 'E6FF80', '1AFF33', '999933',
    'FF3380', 'CCCC00', '66E64D', '4D80CC', '9900B3',
    'E64D66', '4DB380', 'FF4D4D', '99E6E6', '6666FF'
];

const update = (datetime) => { //not my code 
    var theevent = new Date(datetime);
    now = new Date();
    var sec_num = (now - theevent) / 1000;
    var days    = Math.floor(sec_num / (3600 * 24));
    var hours   = Math.floor((sec_num - (days * (3600 * 24)))/3600);
    var minutes = Math.floor((sec_num - (days * (3600 * 24)) - (hours * 3600)) / 60);
    var seconds = Math.floor(sec_num - (days * (3600 * 24)) - (hours * 3600) - (minutes * 60));

    if (hours   < 10) {hours   = "0"+hours;}
    if (minutes < 10) {minutes = "0"+minutes;}
    if (seconds < 10) {seconds = "0"+seconds;}

    return  minutes+':'+seconds;
}//source https://stackoverflow.com/questions/13903897/javascript-return-number-of-days-hours-minutes-seconds-between-two-dates

const getTime = (id) =>{
    socket.emit('time',id);
}

socket.on('time-back',(user)=>{
   let time = update(user.nowTime);
   $(`#${user.id}aa`).show();
   $(`#${user.id}aa`).text(time);
   setTimeout(()=>{
    $(`#${user.id}aa`).hide();
   },2000)
})

socket.on('welcome', (welcome) => {
    $('.chat').append(`<p class="pt-1 pb-1" style="text-align:center;">${welcome}</p>`);
});

socket.on('someone',() => {
    $('#dots').show();
});

socket.on('roomUsers', (users) => {
    $('.users').empty();
    users.forEach(user => {
        var img;
        if (user.imageUrl.includes(".jpg") == false && user.imageUrl.includes(".png") == false){
            var res = user.username.split(" ");
            if (res.length == 2) {
                img = res[0].charAt(0) + res[1].charAt(0);
            }
            else {
                img = res[0].charAt(0);
            }
        }
        $('.users').append(`
            <div class="col-12 pt-1 pb-1">
                <div class="card shadow" id="${user.id}" onclick="getTime(this.id);">
                    <div class="card-body" style="padding: 0;margin: 0;">
                        <p style="padding: 0;margin: 0;" class="card-title p-2">${user.username}</p>
                        <div>
                            <p id="${user.id}aa" style="display:none; padding:0; margin:0;" class="p-2"></p>
                        </div>
                    </div>
                </div>
            </div>`
            );
        });
});

socket.on('newmsg', (msg) => {
    var img;
    if (msg.image.includes(".jpg") == false && msg.image.includes(".png") == false) {
        var res = msg.username.split(" ");
        if (res.length == 2) {
            img = res[0].charAt(0) + res[1].charAt(0);
        }
        else {
            img = res[0].charAt(0);
        }
    }
        $('.chat').append(`
        <div class="col-9 pt-1 pb-1">
            <div class="card shadow">
                <div class="row">
                    <div class="col-2">
                        ${img ?`<div style="background:#${msg.image};color:#${invertHex(msg.image)}; font-size:24px; border-radius:50%; height:45px; width:45px;">
                            <p style="text-align:center;padding-top:3px;">${img}</p>
                            </div>` :`<img src=${msg.image} class="card-img-top card-staff">`}
                    </div>
                    <div class="col-8">
                        <div class="card-body" style="padding: 0;margin: 0;">
                            <h5 style="padding: 0;margin: 0;" class="card-title">${msg.username}</h5>
                            <p style="padding: 0;margin: 0;" class="card-text">${msg.msg}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `);
    $('#dots').hide();
});

let user = {};
$(document).ready(() => {
    $('#dots').hide();
    $('.message').hide();

    $('#sendmessage').bind('keypress',(e) => {
        var code = e.keyCode || e.which;
        if (code == 13) {
            $('#msg').trigger('click');
        }
    });

    $('#enter').click(() => {
        $('.error').empty();
        if (!$('#name').val()) {
            $('.error').append('Enter Your Name, DumbDumb');
            return;
        }
        let username = $('#name').val();
        let image = $('#url').val();
        if (image.includes(".jpg") == false && image.includes(".png") == false) {
            let number = Math.floor(Math.random() * colorArray.length)
            image = colorArray[number];
        }
        user = { username, image };
        socket.emit('createUser', { username, image });
        $('#info').hide();
        $('.message').show();
    });
    $('#continue').click(()=>{
        $('#docu').hide();
        $('#info').show();
    });

    $('#msg').click(()=> {
        let mess = $('#sendmessage').val();
        if (!mess) {
            return;
        }
        $('.chat').append(`
            <div class="col-9 ml-auto pt-1 pb-1">
                <div class="card shadow message-right">
                    <div class="row">
                        <div class="col-8">
                            <div class="card-body" style="padding: 10;">
                                <p class="card-text">${mess}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        `)

        let msg = $('#sendmessage').val();
        user['msg'] = msg;
        socket.emit('chatMessage', user)
        $('#sendmessage').val('');
        $('#sendmessage').attr('placeholder', 'write a message ...');
        $('.chat').scrollTop($('.chat').height());
    });
});

let element = document.getElementById('sendmessage');
element.addEventListener('input', (evt) => {
    socket.emit('typing',{value:1});
});