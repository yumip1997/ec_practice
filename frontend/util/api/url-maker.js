const convertURL = (url) =>  getBaseURL() + url

const getBaseURL = () => isBrowserCall() ? `${process.env.BROWSER_BASE_URL}` : `${process.env.BASE_URL}`

const isBrowserCall = () => `${process.browser}` === "true"

export {
  convertURL
}
