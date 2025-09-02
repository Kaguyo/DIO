import { getBaseEmail} from "./services/emails";

getBaseEmail("Gabriel").then(email => {
    console.log(email);
});