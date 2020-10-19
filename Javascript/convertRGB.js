/*
 * Convert RGB color code to HSV, HSL & CMYK
 *
 * RGB » Red, Green, Blue
 * HEX » Heaxadecimal
 * HSL » Hue, Saturation, Lightness
 * HSV » Hue, Saturation, Value
 */

const convertRGB = (r, g, b) => {
	const [rr, gg, bb] = [r / 255, g / 255, b / 255];
	const max = Math.max(rr, gg, bb);
	const diff = max - Math.min(rr, gg, bb);

	// Calculate HUE for HSV & HSL
	const CalculateHue = () => {
		const h = diff
			? max === rr
				? (gg - bb) / diff
				: max === gg
				? (bb - rr) / diff + 2
				: (rr - gg) / diff + 4
			: 0;

		return Math.round(60 * h < 0 ? 60 * h + 360 : 60 * h);
	};

	const hue = CalculateHue();

	// RGB to Hex
	const toHEX = () => `#${((r << 16) + (g << 8) + b).toString(16).padStart(6, "0")}`;

	// RGB to HSV
	const toHSV = () => [`${hue}%`, `${Math.round(max && (diff / max) * 100)}%`, `${Math.round(max * 100)}%`];

	// RGB to HSL
	const toHSL = () => [
		`${hue}%`,
		`${Math.round(100 * (diff ? (max <= 0.5 ? diff / (2 * max - diff) : diff / (2 - (2 * max - diff))) : 0))}%`,
		`${Math.round((100 * (2 * max - diff)) / 2)}%`,
	];

	// RGB to CMYK
	const toCMYK = (K = Math.min(1 - rr, 1 - gg, 1 - bb)) => [
		`${Math.round(((1 - rr - K) / (1 - K)) * 100)}%`,
		`${Math.round(((1 - gg - K) / (1 - K)) * 100)}%`,
		`${Math.round(((1 - bb - K) / (1 - K)) * 100)}%`,
		`${Math.round(K * 100)}%`,
	];

	return {
		HEX: toHEX(),
		HSV: toHSV(),
		HSL: toHSL(),
		CMYK: toCMYK(),
	};
};

convertRGB(43, 23, 11).HEX; // returns '#2b170b
convertRGB(196, 124, 79).HSV; // returns [ '23%', '60%', '77%' ]
convertRGB(147, 168, 82).HSL; // returns [ '75%', '33%', '49%' ]
convertRGB(105, 105, 105).CMYK; // returns [ '0%', '0%', '0%', '59%' ]
