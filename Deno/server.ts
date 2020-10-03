import { serve } from 'https://deno.land/std@0.73.0/http/server.ts';
const s = serve({ port: 8080 });
console.log('http://localhost:8080/');
for await (const req of s) {
	req.respond({ body: 'Hello World\n' });
}
