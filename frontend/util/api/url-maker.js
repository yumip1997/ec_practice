const convertURL = (url) =>  getBaseURL() + url

const getBaseURL = () => `${process.server}` ? `${process.env.BASE_URL}` : `${process.env.BROWSER_BASE_URL}`

export {
  convertURL
}
