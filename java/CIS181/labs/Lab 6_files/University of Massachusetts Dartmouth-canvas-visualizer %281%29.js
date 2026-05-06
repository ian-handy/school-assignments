(async function() {
    const PANORAMA_SERVER_URL = 'https://panorama-api.yuja.com';
    const panoramaIdentifierKey = '3a7873bf18b7b0a90d828952d533f9f4af386fa852f146479359ba3fd016ee14';
    const PANORAMA_CDN_URL = 'https://cdn-panorama.yuja.com';

    window.PANORAMA_SERVER_URL = PANORAMA_SERVER_URL;
    window.panoramaIdentifierKey = panoramaIdentifierKey;
    window.PANORAMA_CDN_URL = PANORAMA_CDN_URL;

    function loadScript(url) {
        const script = document.createElement('script');
        script.src = url;
        document.head.appendChild(script);
    }

    try {
        const response = await fetch(`${PANORAMA_SERVER_URL}/panorama-visualizer/canvas`, {cache: 'no-store'});
        const scriptUrl = await response.text();
        loadScript(scriptUrl);
    } catch (e) {
        console.error('Failed to load Panorama: ', e);
    }
})();
