#!/bin/bash
echo "🧹 Running spotlessApply to auto-format your code..."
./gradlew spotlessApply

echo ""
echo "🔍 Running spotlessCheck to validate code formatting..."
./gradlew spotlessCheck

echo ""
echo "✅ Done!"
