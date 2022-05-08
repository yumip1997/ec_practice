import axios from "axios";
import {convertURL} from "./url-maker";

//TODO catch 로직 추가하기
const post = async (url, data) => await axios.post(convertURL(url), data);

const get = async (url, params) => await axios.get(convertURL(url), {params: params});

export default {
  post,
  get
}

