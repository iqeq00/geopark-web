$(function () {
    $('.login-wrapper').bgStretcher({
        images: ['/img/bg/01.jpg', '/img/bg/02.jpg', '/img/bg/03.jpg', '/img/bg/04.jpg', '/img/bg/05.jpg'],
        imageWidth: 1920,
        imageHeight: 1080,
        nextSlideDelay: 5000,
        slideDirection: 'N',
        slideShowSpeed: 'slow',
        transitionEffect: 'fade',
        sequenceMode: 'random'
    });
});