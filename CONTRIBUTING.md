# Contributing

Use Conventional Commits:

- `feat:` new functionality
- `fix:` bug fixes
- `docs:` documentation changes
- `test:` tests
- `refactor:` code restructuring without behavior changes
- `chore:` tooling and maintenance

Before opening a pull request, make sure the backend starts and the frontend builds:

```bash
cd backend
npm install
npm run dev

cd ../frontend
npm install
npm run build
```
