import axios from "axios";
import {convertURL} from "./url-maker";

//TODO catch 로직 추가하기
const post = async (url, data) => {
  const response = await axios.post(convertURL(url), data);
  return response;
}

const get = async (url, params) => {
  console.log("브라우저에서 렌더링?" + `${process.browser}`);
  console.log(url);
  const response = await axios.get(convertURL(url), {params: params});
  return response;
}

export default {
  post,
  get
}

