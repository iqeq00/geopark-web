$(function () {
    $('.login-wrapper').bgStretcher({
        images: ['/img/bg/bg1.jpg', '/img/bg/bg2.jpeg', '/img/bg/bg3.jpg', '/img/bg/bg4.jpg', '/img/bg/bg5.jpg', '/img/bg/bg6.jpg'],
        imageWidth: 1920,
        imageHeight: 1080,
        nextSlideDelay: 5000,
        slideDirection: 'N',
        slideShowSpeed: 'slow',
        transitionEffect: 'fade',
        sequenceMode: 'random'
    });
});