const convertURL = (url) =>  isBrowserCall() ? addProxyURL(url) : url

const isBrowserCall = () => `${process.browser}` === "true"

const addProxyURL = (url) => "/api" + url

export {
  convertURL
}
