async function getBaseEmail(senderName : string) : Promise<string> {
    const base = `Olá, me chamo ${senderName}, gostaria de me inscrever!`
    return base;
}

export { getBaseEmail }