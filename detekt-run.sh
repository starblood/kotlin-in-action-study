#!/bin/bash
echo "🔍 Running detekt static analysis..."
./gradlew detekt
echo ""
echo "✅ Done!"
